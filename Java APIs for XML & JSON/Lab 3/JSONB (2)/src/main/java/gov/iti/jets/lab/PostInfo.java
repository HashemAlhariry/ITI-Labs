package gov.iti.jets.lab;

import java.util.List;

public class PostInfo {

        public String title;
        public List<String> commenters;

        public PostInfo(String title, List<String> commenters) {
            this.title = title;
            this.commenters = commenters;
        }
}
