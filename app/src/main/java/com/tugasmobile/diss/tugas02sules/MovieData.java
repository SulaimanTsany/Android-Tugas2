package com.tugasmobile.diss.tugas02sules;

import java.util.ArrayList;

public class MovieData {
    public static String[][] data = new String[][]{
            {"How to Train Your Dragon", "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested", String.valueOf(R.drawable.howtotrainyourdragon), "September 28, 2018", "7.3"},
            {"The Lego", "There's a bad mood rising against the corporate brands. No Logo is the warning on the label. In the last decade, No Logo has become a cultural manifesto for the critics of unfettered capitalism worldwide.", String.valueOf(R.drawable.lego), "November 18, 2018", "8.3"},
            {"Ocean 8", "Debbie Ocean, a criminal mastermind, gathers a crew of female thieves to pull off the heist of the century at New York's annual Met Gala.", String.valueOf(R.drawable.ocean8), "January 21, 2019", "6.3"},
            {"Venom", "Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protec", String.valueOf(R.drawable.venom), "Mei 28, 2019", "7.6"},
            {"Hellboy", "Hellboy comes to England, where he must defeat Nimue, Merlin's consort and the Blood Queen. But their battle will bring about the end of the world, a fate he desperately tries to turn away.", String.valueOf(R.drawable.hellboy), "April 12, 2019", "7.0"},
            {"Shazam!", "A boy is given the ability to become an adult superhero in times of need with a single magic word.", String.valueOf(R.drawable.shazam), "March 23, 2019", "7.2"},
            {"Avengers: Endgame", "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo", String.valueOf(R.drawable.endgames), "April 26, 2019", "6.9"},
            {"Captain Marvel", "The story follows Carol Danvers as she becomes one of the universe’s most powerful heroes when Earth is caught in the middle of a galactic war between two alien races. Set in the 1990s, Captain Marvel is an all", String.valueOf(R.drawable.captainmarvel), "March 8, 2019", "8.8"},
            {"Bumblebee", "On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred", String.valueOf(R.drawable.bumblebee), "December 28, 2019", "9.1"},
    };


    public static ArrayList<Movie> getListData(){
        ArrayList<Movie> list = new ArrayList<>();
        for (String[] aData : data) {
            Movie movie = new Movie();
            movie.setTitle(aData[0]);
            movie.setOverview(aData[1]);
            movie.setPoster_path(aData[2]);
            movie.setRelease_date(aData[3]);
            movie.setVote_average(Float.valueOf(aData[4]));
            list.add(movie);
        }
        return list;
    }
    /*
    {
            "vote_average": 6.5,
            "vote_count": 10148,
            "id": 1930,
            "video": false,
            "media_type": "movie",
            "title": "The Amazing Spider-Man",
            "popularity": 28.45,
            "poster_path": "/eA2D86Y6VPWuUzZyatiLBwpTilQ.jpg",
            "original_language": "en",
            "original_title": "The Amazing Spider-Man",
            "genre_ids": [
                28,
                12,
                14
            ],
            "backdrop_path": "/ujAY1ad7yS2TfV0GDNGUZ7DK0mo.jpg",
            "adult": false,
            "overview": "Peter Parker is an outcast high schooler abandoned by his parents as a boy, leaving him to be raised by his Uncle Ben and Aunt May. Like most teenagers, Peter is trying to figure out who he is and how he got to be the person he is today. As Peter discovers a mysterious briefcase that belonged to his father, he begins a quest to understand his parents' disappearance – leading him directly to Oscorp and the lab of Dr. Curt Connors, his father's former partner. As Spider-Man is set on a collision course with Connors' alter ego, The Lizard, Peter will make life-altering choices to use his powers and shape his destiny to become a hero.",
            "release_date": "2012-06-27"
        },
//        https://image.tmdb.org/t/p/w500/eA2D86Y6VPWuUzZyatiLBwpTilQ.jpg
     */
}
