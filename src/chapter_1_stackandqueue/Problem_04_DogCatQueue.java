package chapter_1_stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_04_DogCatQueue {
	
	public static class Pet {
		private String type;
		
		public Pet(String type) {
			this.type = type;
		}
		
		public String getpetType() {
			return this.type;
		}
	}
	
	public static class Dog extends Pet {
		public Dog() {
			super("Dog");
		}
	}
	
	public static class Cat extends Pet {
		public Cat() {
			super("Cat");
		}
	}
	
	public static class PetEnterQueue {
		private Pet pet;
		private long count;
		
		public PetEnterQueue(Pet pet, long count) {
			this.pet = pet;
			this.count = count;
		}
		
		public Pet getPet() {
			return this.pet;
		}
		
		public long getCount() {
			return this.count;
		}
		
		public String getEnterPetType() {
			return this.pet.getpetType();
		}
	}
	
	public static class DogCatQueue {
		private Queue<PetEnterQueue> dogQ;
		private Queue<PetEnterQueue> catQ;
		private long count;
		
		public DogCatQueue() {
			this.dogQ = new LinkedList<>();
			this.catQ = new LinkedList<>();
			this.count = 0;
		}
		
		public void add(Pet pet) {
			if (pet.getpetType().equals("Dog")) {
				dogQ.add(new PetEnterQueue(pet, count++));
			} else if (pet.getpetType().equals("Cat")) {
				catQ.add(new PetEnterQueue(pet, count++));
			} else {
				throw new RuntimeException("error! not dog or cat!");
			}
		}
		
		public Pet pollAll() {
			if (!dogQ.isEmpty() && !catQ.isEmpty()) {
				if (dogQ.peek().getCount() < catQ.peek().getCount()) {
					return dogQ.poll().getPet();
				} else {
					return catQ.poll().getPet();
				}
			} else if (!dogQ.isEmpty()) {
				return dogQ.poll().getPet();
			} else if (!catQ.isEmpty()) {
				return catQ.poll().getPet();
			} else {
				throw new RuntimeException("error! pet queue is empty!");
			}
		}
		
		public Dog pollDog() {
			if (!dogQ.isEmpty()) {
				return (Dog) dogQ.poll().getPet();
			} else {
				throw new RuntimeException("error! dog queue is empty!");
			}
		}
		
		public Cat pollCat() {
			if (!catQ.isEmpty()) {
				return (Cat) catQ.poll().getPet();
			} else {
				throw new RuntimeException("error! cat queue is empty!");
			}
		}
		
		public boolean isEmpty() {
			return dogQ.isEmpty() && catQ.isEmpty();
		}
		
		public boolean isDogQueueEmpty() {
			return dogQ.isEmpty();
		}
		
		public boolean isCatQueueEmpty() {
			return catQ.isEmpty();
		}
		
		
	}

	public static void main(String[] args) {
		DogCatQueue test = new DogCatQueue();
		
		Pet dog1 = new Dog();
		Pet cat1 = new Cat();
		Pet dog2 = new Dog();
		Pet cat2 = new Cat();
		Pet dog3 = new Dog();
		Pet cat3 = new Cat();
		
		test.add(dog1);
		test.add(cat1);
		test.add(dog2);
		test.add(cat2);
		test.add(dog3);
		test.add(cat3);

		test.add(dog1);
		test.add(cat1);
		test.add(dog2);
		test.add(cat2);
		test.add(dog3);
		test.add(cat3);

		test.add(dog1);
		test.add(cat1);
		test.add(dog2);
		test.add(cat2);
		test.add(dog3);
		test.add(cat3);
		
		while (!test.isDogQueueEmpty()) {
			System.out.println(test.pollDog().getpetType());
		}
		while (!test.isEmpty()) {
			System.out.println(test.pollAll().getpetType());
		}
	}

}
