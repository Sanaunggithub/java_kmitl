package Lab1.pack;

import java.util.Objects;

public class Dog_671725 {
    private Breed breed;
    private int weight;
    
    public Dog_671725(Breed breed, int weight) {
        this.breed = breed;
        this.weight = weight;
    }
    
    public Breed getBreed() {
        return breed;
    }
    
    public int getWeight() {
        return weight;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dog_671725 dog = (Dog_671725) obj;
        return weight == dog.weight && breed == dog.breed;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(breed, weight);
    }
    
    @Override
    public String toString() {
        return "Dog(" + breed + ", " + weight + ")";
    }
}
