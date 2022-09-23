package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping

public class SkillsController {

    @GetMapping
    public String landingPage() {
        return "<html>" +
                "<body>" +
                "<h1>Skills Tracker</h1>" +
                "<h2>We have a few skills we would like to learn. Here is the list!</h2>" +
                "<ol>" +
                "<li>ASSEMBLY</li>" +
                "<li>JavaScript</li>" +
                "<li>Python</li>" +
                "</ol>" +
                // does an href work?
                "<a href=http://localhost:8080/form>Here is the form</a>" +
                "</body>" +
                "</html>";
        }


    // make some HTML and the questions using getmapping
    @GetMapping("form")
    public String skillsForm() {
        // doing the html template with all the +s is annoying there has to be a beter way
        return "<html>" +
                "<body>" +
                //make a form using post and send to selected
                "<form action ='selected' method='POST'>" +
                "<label>Name<br>" +
                "<input type='text' name='name'>" +
                "</label><br>" +
                "<label>My favorite languages:<br>" +
                //tell the post what language the user selected
                "<select name='language1'>" +
                "<option value='JavaScript'>JavaScript</option>" +
                "<option value='Java'>Java</option>" +
                "<option value='Python'>Python</option>" +
                "</select>" +
                "</label></br>" +
                "<label>My second favorite language:<br>" +
                "<select name='language2'>" +
                "<option value='JavaScript'>JavaScript</option>" +
                "<option value='Java'>Java</option>" +
                "<option value='Python'>Python</option>" +
                "</select>" +
                "</label></br>" +
                "<label>My third favorite language:<br>" +
                "<select name='language3'>" +
                "<option value='JavaScript'>JavaScript</option>" +
                "<option value='Java'>Java</option>" +
                "<option value='Python'>Python</option>" +
                "</select>" +
                "</label></br>" +
                "<input type='submit' value='Submit'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    // return the answers from form using requestmapping.get and .post into some new HTML called selected
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "selected")
    public String selectedLanguages(@RequestParam String name, @RequestParam String language1, @RequestParam String language2, @RequestParam String language3) {
        return "<html>" +
                "<body>" +
                "<h1>" + name + "</h1>" +
                "<ol>" +
                "<li>" + language1 + "</li>" +
                "<li>" + language2 + "</li>" +
                "<li>" + language3 + "</li>" +
                "</ol>" +
                "</body>" +
                "</html>";
    }

}