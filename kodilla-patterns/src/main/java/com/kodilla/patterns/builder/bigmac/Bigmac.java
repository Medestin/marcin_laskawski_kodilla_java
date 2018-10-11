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
            if(burgers > 3){
                Logger.getLogger(Logger.class.getName()).log(Level.WARNING, "Too much burgers, setting to 3");
                this.burgers = 3;
                return this;
            } else if(burgers < 1){
                Logger.getLogger(Logger.class.getName()).log(Level.WARNING, "Can't go vegan, setting to 1");
                this.burgers = 1;
                return this;
            } else {
                this.burgers = burgers;
                return this;
            }
        }

        public BigmacBuilder sauce(Sauce sauce){
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredients(Ingredients ingredient){
            this.ingredients.add(ingredient);
            return this;
        }

        public Bigmac build(){
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }

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
                ", ingredients=" + ingredients +
                '}';
    }
}
