package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Find all the anagrams in a vector of words.
 * Your function should return a vector of vectors, where each sub-vector is a group of words which are anagrams of each other.
 * Words without any anagrams should not be included in the result.
 * If there is no anagram, return subvector with string “anagrams not found!”
 */
public class AnagramFinder {

    @Test
    public void test() {
        Assertions.assertEquals(List.of(List.of("veer","ever"), List.of("lake","kale"), List.of("item","mite")),
                solution(List.of("veer","lake","item","kale","mite","ever","rev")));
        Assertions.assertEquals(List.of(List.of("meat","team","mate","mate")), solution(List.of("meat","mat","team","mate","eat","mate")));
        Assertions.assertEquals(List.of(List.of("anagrams not found!")), solution(List.of("there","is","no","anagrams","foo","bar")));
    }

    public List<List<String>> solution(List<String> vector) {
        List<List<String>> result = new ArrayList();
        for(String s : vector) {
            boolean added = false;
            for(List<String> list : result) {
                if(areAnagrams(list.get(0), s)) {
                   added =  list.add(s);
                }
            }
            if(!added) {
                List<String> l = new ArrayList<>();
                l.add(s);
                result.add(l);
            }
        }
        List<List<String>> anagrams = result.stream().filter(list -> list.size() > 1).collect(Collectors.toList());
        if(anagrams.isEmpty()) {
            return List.of(List.of("anagrams not found!"));
        } else {
            return anagrams;
        }
    }

    private boolean areAnagrams(String first, String second) {
        String[] firstArray = first.split("");
        String[] secondArray = second.split("");

        return Arrays.stream(firstArray).sorted().collect(Collectors.joining()).equals(
                Arrays.stream(secondArray).sorted().collect(Collectors.joining()));
    }
}
