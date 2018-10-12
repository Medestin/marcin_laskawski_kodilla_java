package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bigmac {
    private final Bun bun;
    private final int burgers;
    private final Sauce sauce;
    private final List<Ingredients> ingredients;

    private Bigmac(Bun bun, int burgers, Sauce sauce, List<Ingredients> ingredients){
        this.bun = bun;
        this.sauce = sauce;
        this.burgers = burgers;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public int getBurgers() {
        return burgers;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun=" + bun +
                ", burgers=" + burgers +
                ", sauce=" + sauce +
                ", ingredient=" + ingredients +
                '}';
    }

    public static class BigmacBuilder{
        private Bun bun;
        private int burgers;
        private Sauce sauce;
        private List<Ingredients> ingredients = new ArrayList<>();

        public BigmacBuilder bun(Bun bun){
            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgers(int burgers){
           if(validateBurgers(burgers)){
              this.burgers = burgers;
              return this;
           } else {
               throw new IllegalArgumentException("Invalid number of burgers - can't go vegan, " +
                       "also we care about your health, so no more than three.");
           }
        }

        public BigmacBuilder sauce(Sauce sauce){
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredients(List<Ingredients> ingredients){
            this.ingredients.addAll(ingredients);
            return this;
        }

        public BigmacBuilder ingredient(Ingredients ingredient){
            this.ingredients.add(ingredient);
            return this;
        }

        public Bigmac build(){
            return new Bigmac(bun, burgers, sauce, ingredients);
        }

        private boolean validateBurgers(int burgers){
            if(burgers > 0 && burgers < 4){
                return true;
            } else {
                return false;
            }
        }
    }
}
