public class ITunes{

	public static void main(String[] args){

		Playlist pl = new Playlist();

		// TEST: add methods
		pl.addLast("PlanetMoney",26.0); // 4
		pl.addFirst("HowIBuiltThis",10); // 3 
		pl.addLast("EzraKleinShow",65.0);  // 5 
		pl.addFirst("RadioLab",25.5); // 1 
		pl.addLast("Invisibilia",33.5); // 6 
		pl.add("MakeMeSmart",24.5, 1); // 2 
		pl.add("Worldly",55, 6); // 8 
		pl.add("Explained",23.0, 6);  // 7 
		pl.add("RadioLab",25.5, 0); // 0 

		System.out.println(pl.displayPlaylistForward());
		System.out.println(pl.displayPlaylistBackward());

		// TEST: delete methods
		// System.out.println("--------------------------------------------");
		// pl.deleteEpisode("PlanetMoney");
		// System.out.println(pl.displayPlaylistForward());
		// System.out.println(pl.displayPlaylistBackward());
		// System.out.println("--------------------------------------------");
		// pl.deleteEpisode("RadioLab");
		// System.out.println(pl.displayPlaylistForward());
		// System.out.println(pl.displayPlaylistBackward());
		// System.out.println("--------------------------------------------");
		// pl.deleteEpisode("Worldly");
		// System.out.println(pl.displayPlaylistForward());
		// System.out.println(pl.displayPlaylistBackward());
		// System.out.println("--------------------------------------------");
		// pl.deleteEpisode("MakeMeSmart");
		// System.out.println(pl.displayPlaylistForward());
		// System.out.println(pl.displayPlaylistBackward());
		// System.out.println("--------------------------------------------");


		// TEST: deleteEveryMthEpisode() 
		System.out.println(pl.displayPlaylistForward());
		System.out.println(pl.displayPlaylistBackward());

		pl.deleteEveryMthEpisode(3);

		System.out.println(pl.displayPlaylistForward());
		System.out.println(pl.displayPlaylistBackward());


		// Playlist pl2 = new Playlist();

		// for (int i = 1; i < 101; i++) {
		// 	pl2.addLast(i + "", i);
		// }

		// pl2.add(100 + "", 100, 100);
		// pl2.add(10 + "", 10, 10);
		// pl2.addLast(100 + "", 100);
		// pl2.add(1 + "", 1, 1);
		// pl2.addFirst(1 + "", 1);

		// System.out.println(pl2.displayPlaylistForward());
		// System.out.println(pl2.displayPlaylistBackward());

		// pl2.deleteEpisode("10");
		// pl2.deleteFirst();
		// pl2.deleteLast();
		// pl2.deleteEpisode("1");
		// pl2.deleteEpisode("100");

		// System.out.println(pl2.displayPlaylistForward());
		// System.out.println(pl2.displayPlaylistBackward());

	}
}
