package acsl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import java.util.Scanner;

public class ACSL_Contest1_2016_17_AGRAM_ChetanAlla {

	public static void main(String[] args) {
		
		for(int j = 0; j < 5; j ++){
		
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		input = input.replaceAll(" ", "");
		int lCard = Integer.parseInt(input.substring(0, 1)); // lead card
		String lSuit = input.substring(2, 3); //lead Suit
		input = input.substring(4);
		String [] inputsplit = input.split(",");
		List<Integer> cards = new ArrayList<Integer>(); //Deal Cards
		
		for(int i = 0; i < inputsplit.length; i = i + 2 ){
			if((inputsplit[i + 1].equals(lSuit))){
				cards.add(Integer.parseInt(inputsplit[i]));
			}
		}
		
		if(cards.size() < 1){
			System.out.println("NONE");
		}else{
			Collections.sort(cards);
			Collections.reverse(cards);
			int current = lCard;
			for(int i = 0; i < cards.size(); i ++){
				if(lCard < cards.get(i)){
					if(current != lCard && cards.get(i) > lCard){
						current = cards.get(i);
					}else if(current == lCard){
						current = cards.get(i);
					}
				}else if(current > cards.get(i) && current == lCard){
					Collections.reverse(cards);
					current = cards.get(0);
				}
			}
			System.out.println(current + ", " + lSuit);
		}}

}}
