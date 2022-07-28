package com.smashingmods.alchemistry.common.recipe.dissolver;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.collection.DefaultedList;

import java.util.*;
import java.util.stream.IntStream;

public class ProbabilitySet {

    private final List<ProbabilityGroup> probabilityGroups;
    private final boolean weighted;
    private final int rolls;

    public ProbabilitySet(List<ProbabilityGroup> pProbabilityGroups) {
        this(pProbabilityGroups, true, 1);
    }

    public ProbabilitySet(List<ProbabilityGroup> pProbabilityGroups, boolean pWeighted, int pRolls) {
        this.probabilityGroups = pProbabilityGroups;
        this.weighted = pWeighted;
        this.rolls = pRolls;
    }

    public JsonElement serialize() {
        JsonObject toReturn = new JsonObject();
        JsonArray jsonArray = new JsonArray();

        toReturn.add("rolls", new JsonPrimitive(rolls));
        toReturn.add("weighted", new JsonPrimitive(weighted));

        for (ProbabilityGroup group : probabilityGroups) {
            jsonArray.add(group.serialize());
        }
        toReturn.add("groups", jsonArray);

        return toReturn;
    }

    public void write(PacketByteBuf pBuffer) {
        pBuffer.writeInt(probabilityGroups.size());
        pBuffer.writeInt(rolls);
        pBuffer.writeBoolean(weighted);
        for (ProbabilityGroup group : probabilityGroups) {
            group.write(pBuffer);
        }
    }

    public static ProbabilitySet read(PacketByteBuf pbuffer) {
        List<ProbabilityGroup> groupArrayList = new ArrayList<>();
        int size = pbuffer.readInt();
        int rolls = pbuffer.readInt();
        boolean weighted = pbuffer.readBoolean();

        for (int index = 0; index < size; index++) {
            groupArrayList.add(ProbabilityGroup.read(pbuffer));
        }
        return new ProbabilitySet(groupArrayList, weighted, rolls);
    }

    public DefaultedList<ItemStack> calculateOutput() {
        DefaultedList<ItemStack> toReturn = DefaultedList.of();
        Random random = new Random();

        for (int i = 1; i <= rolls; i++) {
            double totalProbability = getTotalProbability();
            double targetProbability = random.nextDouble();

            if (weighted) {
                double outputProbability = 0.0;

                for (ProbabilityGroup group : probabilityGroups) {
                    outputProbability += (group.getProbability() / totalProbability);

                    if (outputProbability >= targetProbability) {
                        group.getOutput().forEach(itemStack -> populateReturnList(toReturn, itemStack));
                        break;
                    }
                }
            } else {
                if ((totalProbability / 100) < targetProbability) return toReturn;

                for (ProbabilityGroup group : probabilityGroups) {
                    if (group.getProbability() >= random.nextInt(101)) {
                        group.getOutput().forEach(itemStack -> populateReturnList(toReturn, itemStack));
                    }
                }
            }
        }
        return toReturn;
    }

    private void populateReturnList(DefaultedList<ItemStack> pList, ItemStack pItemStack) {

        Item item = pItemStack.copy().getItem();
        int count = pItemStack.copy().getCount();

        OptionalInt optionalIndex = IntStream.range(0, pList.size())
                .filter(index -> ItemStack.canCombine(pItemStack.copy(), pList.get(index)))
                .findFirst();

        if (count > 64) {
            while (count > 0) {
                if (count >= 64) {
                    pList.add(new ItemStack(item, 64));
                    count -= 64;
                } else {
                    pList.add(new ItemStack(item, count));
                    count = 0;
                }
            }
        } else {
            if (optionalIndex.isPresent()) {
                pList.get(optionalIndex.getAsInt()).increment(count);
            } else {
                pList.add(new ItemStack(item, count));
            }
        }
    }


    public List<ProbabilityGroup> getProbabilityGroups() {
        return probabilityGroups;
    }

    public boolean isWeighted() {
        return weighted;
    }

    public int getRolls() {
        return rolls;
    }

    private double getTotalProbability() {
        return probabilityGroups.stream()
                .mapToDouble(ProbabilityGroup::getProbability)
                .sum();
    }

    public static class Builder {
        private final List<ProbabilityGroup> groups = new ArrayList<>();
        private boolean weighted = false;
        private int rolls = 1;

        public Builder() {}

        public static Builder createSet() {
            return new Builder();
        }

        public Builder addGroup(ProbabilityGroup pGroup) {
            groups.add(pGroup);
            return this;
        }

        public Builder addGroup(List<ItemStack> itemStacks) {
            groups.add(new ProbabilityGroup(itemStacks));
            return this;
        }

        public Builder addGroup(List<ItemStack> itemStacks, double pProbability) {
            groups.add(new ProbabilityGroup(itemStacks, pProbability));
            return this;
        }

        public Builder addGroup(ItemStack... pItemStacks) {
            groups.add(new ProbabilityGroup(Arrays.asList(pItemStacks)));
            return this;
        }

        public Builder addGroup(double pProbability, ItemStack... pItemStacks) {
            if (pItemStacks.length == 0) {
                groups.add(new ProbabilityGroup(List.of(ItemStack.EMPTY), pProbability));
            } else {
                groups.add(new ProbabilityGroup(Arrays.asList(pItemStacks), pProbability));
            }
            return this;
        }

        public Builder rolls(int rolls) {
            this.rolls = rolls;
            return this;
        }

        public Builder weighted() {
            this.weighted = true;
            return this;
        }

        public ProbabilitySet build() {
            return new ProbabilitySet(groups, weighted, rolls);
        }
    }
}
