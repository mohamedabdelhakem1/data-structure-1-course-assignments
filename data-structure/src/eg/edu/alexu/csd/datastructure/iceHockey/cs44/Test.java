package eg.edu.alexu.csd.datastructure.iceHockey.cs44;
import java.awt.Point;
public class Test {

	public static void main(String[] args) {
		Icehockey icehockey = new Icehockey();
		String[] players = {"44444H44S4",
				"K444K4L444",
				"4LJ44T44XH",
				"444O4VIF44",
				"44C4D4U444",
				"4V4Y4KB4M4",
				"G4W4HP4O4W",
				"4444ZDQ4S4",
				"4BR4Y4A444",
				"4G4V4T4444",} ;
		Point[] points;
		points = icehockey.findPlayers(players, 4, 16);
		for(Point pp:points) {
			System.out.println(pp);
			}

	}

}
