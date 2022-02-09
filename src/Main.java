/*Eleven skall utveckla ett sten-sax-påse-spel. Den fördjupande uppgiften innefattar att
vidareutveckla och vid behov omstruktuera koden så att spelet:
        ● Datormotståndarna ska ha minst 3 olika ”personligheter” – en väljer drag slumpvis, en
        väljer drag efter vilken minut klockan är, en väljer drag efter hur många vokaler som ingår i
        motståndarens namn.
        ● Slutresultatet för varje avslutad turnering ska sparas tillsammans med tid och datum -
        antingen i minnet, t.ex. genom en lista, eller med hjälp av en databas. Programmet skall
        sedan kunna visa statistik om olika spelares snittplacering i turneringen, bästa placering
        samt sämsta placering
        ● För VG krävs därtill att programmet nyttjar sig av minst 1 etablerat designpattern. Det
        valda designpattern skall markeras och namnges i koden genom en kommentar.*/

import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        LocalDateTime localTime = LocalDateTime.now();
        int slumpiScore = 0;
        int lasiScore = 0;
        int timmiScore = 0;
        int gamerScore = 0;

        //Börja spel
        System.out.println("Välkommen till Sten-Sax-Påse! \nSkriv ditt namn");
        String gamerName = scanner.nextLine();

        // 1. Spel med Slumpi
        while (true) {
            int slumpiChoice = random.nextInt(3) + 1;

            System.out.println("Gör ditt vall " + gamerName + "\n1. Sten \n2. Sax \n3. Påse");
            int gamerChoice = scanner.nextInt();

            if (gamerChoice == 1) {
                System.out.println("Du valde sten.");
                if (slumpiChoice == 1) {
                    System.out.println("Slumpi valde sten. Tie");
                } else if (slumpiChoice == 2) {
                    System.out.println("Slumpi valde sax. Du vann.");
                    gamerScore++;
                } else if (slumpiChoice == 3) {
                    System.out.println("Slumpi valde påse. Slumpi vann.");
                    slumpiScore++;
                }
            } else if (gamerChoice == 2) {
                System.out.println("Du valde sax.");
                if (slumpiChoice == 2) {
                    System.out.println("Slumpi valde sax. Tie");
                } else if (slumpiChoice == 1) {
                    System.out.println("Slumpi valde sten. Slumpi vann.");
                    slumpiScore++;
                } else if (slumpiChoice == 3) {
                    System.out.println("Slumpi valde påse. Du vann.");
                    gamerScore++;
                }
            } else if (gamerChoice == 3) {
                System.out.println("Du valde påse.");
                if (slumpiChoice == 3) {
                    System.out.println("Slumpi valde påse. Tie");
                } else if (slumpiChoice == 1) {
                    System.out.println("Slumpi valde sten. Du vann.");
                    gamerScore++;
                } else if (slumpiChoice == 2) {
                    System.out.println("Slumpi valde sax. Slumpi vann.");
                    slumpiScore++;
                }
            }
            else {
                System.out.println("Ditt val är fel");
                break;
            }

            // 2. Spel med Timmi
            int timmiChoice = 0;
            if (localTime.getMinute() < 20) {
                timmiChoice = 1;
            } else if (localTime.getMinute() >= 20 && localTime.getMinute() < 40) {
                timmiChoice = 2;
            } else if (localTime.getMinute() >= 40 && localTime.getMinute() < 60) {
                timmiChoice = 3;
            }

            System.out.println("Gör ditt vall " + gamerName + "\n1. Sten \n2. Sax \n3. Påse");
            gamerChoice = scanner.nextInt();
            if (gamerChoice == 1) {
                System.out.println("Du valde sten.");
                if (timmiChoice == 1) {
                    System.out.println("Timmi valde sten. Tie");
                } else if (timmiChoice == 2) {
                    System.out.println("Timmi valde sax. Du vann.");
                    gamerScore++;
                } else if (timmiChoice == 3) {
                    System.out.println("Timmi valde påse. Timmi vann.");
                    timmiScore++;
                }
            } else if (gamerChoice == 2) {
                System.out.println("Du valde sax.");
                if (timmiChoice == 2) {
                    System.out.println("Timmi valde sax. Tie");
                } else if (timmiChoice == 1) {
                    System.out.println("Timmi valde sten. Timmi vann.");
                    timmiScore++;
                } else if (timmiChoice == 3) {
                    System.out.println("Timmi valde påse. Du vann.");
                    gamerScore++;
                }
            } else if (gamerChoice == 3) {
                System.out.println("Du valde påse.");
                if (timmiChoice == 3) {
                    System.out.println("Timmi valde påse. Tie");
                } else if (timmiChoice == 1) {
                    System.out.println("Timmi valde sten. Du vann.");
                    gamerScore++;
                } else if (timmiChoice == 2) {
                    System.out.println("Timmi valde sax. Timmi vann.");
                    timmiScore++;
                }
            }
            else {
                System.out.println("Ditt val är fel");
                break;
            }

            //3. Spel med Lasi
            int lasiChoice = 0;
            Pattern vocals = Pattern.compile("[AaEeIiOoUu]");
            Matcher m = vocals.matcher(gamerName);
            int vocalCount = 0;
            while (m.find()) {
                vocalCount++;
            }
            if (vocalCount < 2) {
                lasiChoice = 1;
            } else if (vocalCount == 2) {
                lasiChoice = 2;
            } else if (vocalCount > 2) {
                lasiChoice = 3;
            }

            System.out.println("Gör ditt vall " + gamerName + "\n1. Sten \n2. Sax \n3. Påse");
            gamerChoice = scanner.nextInt();
            if (gamerChoice == 1) {
                System.out.println("Du valde sten.");
                if (lasiChoice == 1) {
                    System.out.println("Lasi valde sten. Tie");
                } else if (lasiChoice == 2) {
                    System.out.println("Lasi valde sax. Du vann.");
                    gamerScore++;
                } else if (lasiChoice == 3) {
                    System.out.println("Lasi valde påse. Lasi vann.");
                    lasiScore++;
                }
            } else if (gamerChoice == 2) {
                System.out.println("Du valde sax.");
                if (lasiChoice == 2) {
                    System.out.println("Lasi valde sax. Tie");
                } else if (lasiChoice == 1) {
                    System.out.println("Lasi valde sten. Lasi vann.");
                    lasiScore++;
                } else if (lasiChoice == 3) {
                    System.out.println("Lasi valde påse. Du vann.");
                    gamerScore++;
                }
            } else if (gamerChoice == 3) {
                System.out.println("Du valde påse.");
                if (lasiChoice == 3) {
                    System.out.println("Lasi valde påse. Tie");
                } else if (lasiChoice == 1) {
                    System.out.println("Lasi valde sten. Du vann.");
                    gamerScore++;
                } else if (lasiChoice == 2) {
                    System.out.println("Lasi valde sax. Lasi vann.");
                    lasiScore++;
                }
            }
            else {
                System.out.println("Ditt val är fel");
                break;
            }

//Spåra resultat
            List<Gamer>result=
                    List.of(
                            new Gamer(gamerName,gamerScore),
                            new Gamer("Slumpi", slumpiScore),
                            new Gamer("Timmi",timmiScore),
                            new Gamer("Lasi",lasiScore)
                    );

            //Till huvudmeny
            System.out.println("Du har spelat med alla spelare. Gör ditt val. " +
                    "\n1. Spela igen \n2. Visa turneringsstatistik \n3. Avsluta");
            int menuChoice;
            menuChoice = scanner.nextInt();

            if (menuChoice == 1) {
                System.out.println("Ny spel");
            }
            else if (menuChoice == 2) {
                System.out.println("Turnering är avslutat "+ localTime+"\nSlutresultatet är "+result);
                System.out.println("Snittresultat: "+result
                        .stream()
                        .collect(Collectors.averagingDouble(Gamer::getScore))
                );
                System.out.println("Bästa placering: "+result
                        .stream()
                        .max(Comparator.comparing(Gamer::getScore))
                );
                System.out.println("Sämsta placering: "+result
                        .stream()
                        .min(Comparator.comparing(Gamer::getScore))
                );
                break;
            }
            else if (menuChoice == 3) {
                System.out.println("Game over!");
                break;
            }
            else {
                System.out.println("Ditt val är fel");
                break;
            }
        }
    }
}
