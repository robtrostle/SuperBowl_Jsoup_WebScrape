package API_Week;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
/*
    Lab Assignment 6 - Determine number of Superbowls
 */
public class LabAssign_6_Trostle3 {

    public static void main(String[] args) throws IOException {
        String[] winners = new String[55];//Create a string array to store winners
        String url = "https://blog.ticketcity.com/nfl/super-bowl/super-bowl-champions/";
        Document doc = Jsoup.connect(url).get();
        
        Elements trs = doc.select("table tr");//gets the table rows(tr) from the table

        int i = 0;//increment variable
    
for(Element tr : trs)//iterate through the table rows.
{
        if(tr.select("td:nth-of-type(1)").text().equals("")){//skips the first empty row
            continue;
        }else{
            final String sbWinner = tr.select("td:nth-of-type(3)").text();//Assigns the 3rd column(Champions)
            winners[i] = sbWinner;//load the winners array with the winner
        }
        i++;
}
        String userTeam = getTeam();//Get the user's team 
          
        List<String> list = Arrays.asList(winners);
                //contains method to check if userTeam is inside the winners list
                int count = 0;
                if (list.contains(userTeam)){
                    for (int j = 0; j < list.size(); j++) {
                        if(list.get(j).equalsIgnoreCase(userTeam))
                        count++;
                    }
                    System.out.println("The " + userTeam + " have won " + count + " super bowl(s). ");
                }else{
                    System.out.println("I don't know how to tell you this, but the "
                    + userTeam + " have literally never won a super bowl. :(");
                }
    }
        public static String getTeam(){
            Scanner scan = new Scanner(System.in);
            
            String team;

            System.out.print("Enter a team name (excluding \"the\") and I will tell you how many "
                    + "times they have won the Super Bowl--> "  );
            team = scan.nextLine();
            
            return team;
        }    
}
    
    

