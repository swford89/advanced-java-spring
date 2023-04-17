package platform.codingnomads.co.springweb.springrestcontrollers.simpledemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversionController {

    private final String text = "this is the text that this is all based on.";

    @RequestMapping(path = "/binary", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String returnSomeBinary() {
        StringBuilder binary = new StringBuilder();
        char[] chars = text.toCharArray();

        for(char c: chars) {
            binary.append("   ").append(Integer.toBinaryString(c));
        }
        return binary.toString();
    }

    @RequestMapping(path = "/normal", method = RequestMethod.GET)
    public String returnTheString() {
        return text;
    }

    @RequestMapping(path = "/backwards/{word}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String backwardsString(@PathVariable(name = "word") String word) {
        String pathVar = word;
        char[] pathVarArray = word.toCharArray();
        int pathVarLength = pathVar.length();
        int laterCounter = 1;

        for(int beforeCounter = 0; beforeCounter < pathVarLength/2; beforeCounter++){
            char tempHolder = pathVarArray[beforeCounter];
            // move last letter to start
            pathVarArray[beforeCounter] = pathVarArray[pathVarLength - laterCounter];
            // move first letter to end
            System.out.println(String.valueOf(pathVarArray));
            laterCounter += 1;
        }
        String backwardsString = String.valueOf(pathVarArray);
        return backwardsString;
    }
}