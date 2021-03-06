package com.example.springexample;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.boot.SpringApplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@SpringBootApplication
@Controller

public class SpringexampleApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(
      SpringApplicationBuilder builder) {
        return builder.sources(SpringexampleApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringexampleApplication.class, args);
	}

	
	@RequestMapping("/abc")
	@ResponseBody
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/getdata")
	@ResponseBody
	public Json getData() {
		Json js=new Json();
		js.setName("amit");
		js.setAdr("delhi");
		return js;
		
	}
	
	@RequestMapping(value="/load" ,method=RequestMethod.POST)
	
	public void load(@RequestBody UserDetails user) {
		System.err.println(user.getId());
		System.err.println(user.getName());
		
	}
	
	
	@RequestMapping("/")
	public String welcome() {
		return "index";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST, 
		      consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
		   
		   public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		      File convertFile = new File("/var/tmp/"+file.getOriginalFilename());
		      convertFile.createNewFile();
		      FileOutputStream fout = new FileOutputStream(convertFile);
		      fout.write(file.getBytes());
		      fout.close();
		      return "File is upload successfully";
		   }
	
	@RequestMapping(value = "/download", method = RequestMethod.GET) 
	public ResponseEntity<Object> downloadFile() throws IOException  {
	   String filename = "C:\\Users\\Lenovo\\Pictures\\ak.jpg";
	   File file = new File(filename);
	   InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
	   HttpHeaders headers = new HttpHeaders();
	      
	   headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
	   headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
	   headers.add("Pragma", "no-cache");
	   headers.add("Expires", "0");
	      
	   ResponseEntity<Object> 
	   responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(
	      MediaType.parseMediaType("application/txt")).body(resource);
	      
	   return responseEntity;
	}
	
}

