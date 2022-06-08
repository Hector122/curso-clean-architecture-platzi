package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/group-anagrams/
public class GroupsOfAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> listOfAnagram = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(String word : strs){
            char[] characters = word.toCharArray();

            // sort the array
            Arrays.sort(characters);
            String sorted = new String(characters);

            if(!map.containsKey(sorted)){
                //add to map
                map.put(sorted, new ArrayList<>());
            }

            map.get(sorted).add(word);
        }

        // add all map values.
        listOfAnagram.addAll(map.values());
        return  listOfAnagram;
    }
}
