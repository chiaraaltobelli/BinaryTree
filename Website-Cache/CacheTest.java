import java.util.LinkedList;

public class CacheTest {
    public static void main(String args[]) {
        // Set variables from command line
        int max = 0;//hold max size of cache list
        int webPages = 0;//total webpages to  be generated
        double stdDev = 0.0;//standard deviation
        long seed = 0;//seed (optional)
        int debugLvl = 0;//debug level 0-3

        // Exit program if valid args are not entered
        if (args.length != 4 && args.length != 5) {
            System.out.println("Please enter valid arguments.");
            System.exit(0);
        }

        try {
            //Get values from command line args
            max = Integer.parseInt(args[0]);
            webPages = Integer.parseInt(args[1]);
            stdDev = Double.parseDouble(args[2]);
            debugLvl = Integer.parseInt(args[3]);

            // Exit program if arguments are not valid
            if (max < 1 || webPages < 1 || stdDev < 0 || debugLvl < 0 || debugLvl > 3) {
                System.out.println("Please enter valid arguments.");
                System.exit(0);
            }
            //assign seed if provided
            if (args.length == 5) {
                seed = Long.parseLong(args[4]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid command line arguments.");
            System.exit(0);
        }

        // Get start time
        long startTime = System.currentTimeMillis();

        // Call WebpageGenerator to get webpage objects that will be cached
        WebpageGenerator newWebPageGen;
        if (seed > 0) {//if seed provided
            newWebPageGen = new WebpageGenerator(webPages, stdDev, seed);
        } else {//without seed
            newWebPageGen = new WebpageGenerator(webPages, stdDev);
        }

        // Create cache to store webpages
        Cache<String, Webpage> myCache = new Cache<>(max);

        // Generate webpage URL
        for (int i = 0; i < webPages; i++) {
            String key = newWebPageGen.getURL(); // Get new URL and store as key
                Webpage value = myCache.get(key); // See if stored in cache
                if (value == null) {
                        value = newWebPageGen.readPage(key);//if not in cache list, get value
                        Webpage removedVal = myCache.add(value);//add value to cache list
                    }
        }

        // Get current time to calculate elapsed time
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - startTime;

        // Print debug information
        LinkedList<Webpage> cacheList = myCache.getCacheList();//get cache list to print data
        switch (debugLvl) {
            case 0:
                break;//just print the toString cache stats
            case 1:
                for (int i = 0; i < cacheList.size(); i++) {
                    // Access and process each webpage in the cache
                    Webpage webpage = cacheList.get(i);
                    String url = webpage.getWebpageURL(); // Get the URL of the webpage
                    double references = myCache.getReferences(i); // Get the references for the webpage using the index
                    // Check if the webpage is null before accessing its properties
                    if (webpage != null) {
                        System.out.println("[" + url + "]: " + references);
                    } else {
                        System.out.println("Webpage at index " + i + " is null");
                    }
                }
                break;
            case 2:
                for (int i = 0; i < cacheList.size(); i++) {
                    // Access and process each webpage in the cache
                    Webpage webpage = cacheList.get(i);
                    String url = webpage.getWebpageURL(); // Get the URL of the webpage
                    String content = webpage.getSummarizedWebpageContent();//get summarized content
                    // Check if the webpage is null before accessing its properties
                    if (webpage != null) {
                        System.out.println("[" + url + "]: " + content);
                    } else {
                        System.out.println("Webpage at index " + i + " is null");
                    }
                }
                break;
            case 3:
                for (int i = 0; i < cacheList.size(); i++) {
                    // Access and process each webpage in the cache
                    Webpage webpage = cacheList.get(i);
                    String url = webpage.getWebpageURL(); // Get the URL of the webpage
                    String content = webpage.getWholeWebpageContent();//get summarized content
                    // Check if the webpage is null before accessing its properties
                    if (webpage != null) {
                        System.out.println("[" + url + "]: " + content);
                    } else {
                        System.out.println("Webpage at index " + i + " is null");
                    }
                }
                break;
        }

        //Print stats and elapsed time
        System.out.println(myCache.toString());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Time elapsed: " + String.format("%.1f", (double) elapsedTime) + " milliseconds\n");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
