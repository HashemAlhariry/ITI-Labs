package gov.iti.jets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/uploadFile")
public class UploadingFileController {

    @RequestMapping(method = RequestMethod.GET)
    public String getUploadForm() {
        return "uploadForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String uploadFileHandler(@RequestParam("file") MultipartFile file){
        if(!file.isEmpty()){
            return "You successfully upload file"+file.getOriginalFilename();
        }
        return "File upload failed Empty file";
    }
}
