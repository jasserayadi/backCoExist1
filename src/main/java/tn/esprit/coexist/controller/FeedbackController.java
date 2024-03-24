package tn.esprit.coexist.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.coexist.entity.FeedBack;
import tn.esprit.coexist.service.FeedbackService;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class FeedbackController {
    FeedbackService feedbackService;
    @PostMapping("/addFeedback")
    public FeedBack addFeedback(@RequestBody FeedBack feedBack){
        return feedbackService.addFedback(feedBack);

    }


}
