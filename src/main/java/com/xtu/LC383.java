package com.xtu;

public class LC383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] nums = new int[24];
        for (int i = 0; i < magazine.length(); i++) {
            nums[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            nums[ransomNote.charAt(i) - 'a']--;
            if (nums[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
