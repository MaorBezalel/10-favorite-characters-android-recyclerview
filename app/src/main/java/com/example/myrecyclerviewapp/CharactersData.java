package com.example.myrecyclerviewapp;

public class CharactersData {

    public static final int CHARACTERS_COUNT = 10;
    public static final String[] NAMES = new String[CHARACTERS_COUNT];

    public static final String[] SHORT_DESCRIPTIONS = new String[CHARACTERS_COUNT];

    public static final String[] LONG_DESCRIPTIONS = new String[CHARACTERS_COUNT];

    public static final int[] PROFILES = new int[CHARACTERS_COUNT];

    static {
        // 1. SpongeBob SquarePants:
        NAMES[0] = "SpongeBob SquarePants";
        SHORT_DESCRIPTIONS[0] = "The main character of the show.";
        LONG_DESCRIPTIONS[0] = "SpongeBob SquarePants, a sea sponge, lives in a pineapple in Bikini Bottom with his pet snail, Gary. He is a skilled fry cook at the Krusty Krab.";
        PROFILES[0] = R.drawable.spongebob_squarepants;

        // 2. Patrick Star:
        NAMES[1] = "Patrick Star";
        SHORT_DESCRIPTIONS[1] = "SpongeBob's best friend.";
        LONG_DESCRIPTIONS[1] = "Patrick Star, a pink starfish, lives under a rock in Bikini Bottom. He is SpongeBob's best friend, known for his laziness and lack of intelligence.";
        PROFILES[1] = R.drawable.patrick_star;

        // 3. Squidward Tentacles:
        NAMES[2] = "Squidward Tentacles";
        SHORT_DESCRIPTIONS[2] = "SpongeBob's neighbor and co-worker.";
        LONG_DESCRIPTIONS[2] = "Squidward Tentacles, an octopus, is SpongeBob' neighbor and co-worker. He often finds himself annoyed by SpongeBob and Patrick and dreams of becoming a famous artist.";
        PROFILES[2] = R.drawable.squidward_tentacles;

        // 4. Sandy Cheeks:
        NAMES[3] = "Sandy Cheeks";
        SHORT_DESCRIPTIONS[3] = "SpongeBob's friend from Texas.";
        LONG_DESCRIPTIONS[3] = "Sandy Cheeks, a squirrel from Texas, lives in an air dome in Bikini Bottom. She is a scientist, inventor, and karate expert.";
        PROFILES[3] = R.drawable.sandy_cheeks;

        // 5. Gray the Snail:
        NAMES[4] = "Gary the Snail";
        SHORT_DESCRIPTIONS[4] = "SpongeBob's pet.";
        LONG_DESCRIPTIONS[4] = "Gary the Snail is SpongeBob's pet. He is intelligent and communicates with others through meowing.";
        PROFILES[4] = R.drawable.gary_the_snail;

        // 6. Mr. Krabs:
        NAMES[5] = "Mr. Krabs";
        SHORT_DESCRIPTIONS[5] = "SpongeBob's boss at the Krusty Krab.";
        LONG_DESCRIPTIONS[5] = "Mr. Krabs, a crab, owns the Krusty Krab restaurant in Bikini Bottom. He is SpongeBob's and Squidward's boss, known for his obsession with money.";
        PROFILES[5] = R.drawable.mr_krabs;

        // 7. Pearl Krabs:
        NAMES[6] = "Pearl Krabs";
        SHORT_DESCRIPTIONS[6] = "Mr. Krabs' teenage daughter.";
        LONG_DESCRIPTIONS[6] = "Pearl Krabs, a whale, is Mr. Krabs' teenage daughter. She is a cheerleader and often seen with her friends.";
        PROFILES[6] = R.drawable.pearl_krabs;

        // 8. Plankton:
        NAMES[7] = "Plankton";
        SHORT_DESCRIPTIONS[7] = "Mr. Krabs' nemesis.";
        LONG_DESCRIPTIONS[7] = "Plankton, a small green copepod, owns the Chum Bucket restaurant in Bikini Bottom. He is Mr. Krabs' nemesis, always trying to steal the Krabby Patty secret formula.";
        PROFILES[7] = R.drawable.plankton;

        // 9. Karen Plankton:
        NAMES[8] = "Karen Plankton";
        SHORT_DESCRIPTIONS[8] = "Plankton's wife.";
        LONG_DESCRIPTIONS[8] = "Karen Plankton, a computer, is Plankton's wife. She co-owns the Chum Bucket and assists Plankton in his schemes.";
        PROFILES[8] = R.drawable.karen_plankton;

        // 10. Mrs. Puff:
        NAMES[9] = "Mrs. Puff";
        SHORT_DESCRIPTIONS[9] = "SpongeBob's boating school teacher.";
        LONG_DESCRIPTIONS[9] = "Mrs. Puff, a pufferfish, is SpongeBob's boating school teacher. She is often exasperated by SpongeBob's reckless driving.";
        PROFILES[9] = R.drawable.mrs_puff;
    }

    private CharactersData() {} // Prevent instantiation --> static class
}
