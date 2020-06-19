package senderexample;

import com.silanis.esl.sdk.DocumentPackage;
import com.silanis.esl.sdk.EslClient;
import com.silanis.esl.sdk.PackageId;
import com.silanis.esl.sdk.Visibility;
import com.silanis.esl.sdk.builder.DocumentBuilder;
import com.silanis.esl.sdk.builder.PackageBuilder;
import com.silanis.esl.sdk.builder.SenderInfoBuilder;
import com.silanis.esl.sdk.builder.SignatureBuilder;
import com.silanis.esl.sdk.builder.SignerBuilder;

public class exampleSender {
	
	public static final String API_KEY = "OG1Nb3VrVFNySk03OnJWVWlRT1llOWpNRg==";
	public static final String API_URL = "https://sandbox.esignlive.com/api";
	
	 public static void main(String... args) {
	    	EslClient eslClient = new EslClient(API_KEY, API_URL);
	    	

	        // Create a template on behalf of another sender
	      
	    	DocumentPackage package1 = PackageBuilder.newPackageNamed("New Package")
	    	        .withSigner(SignerBuilder.newSignerWithEmail("shrutimukherjee2020@gmail.com" )
	    	                .withFirstName("Shruti")
	    	                .withLastName("Mukherjee"))
	    	        .withDocument(DocumentBuilder.newDocumentWithName("document 1")
	    	        		.fromFile("your document path")
	    	        		.withSignature(SignatureBuilder.signatureFor("shrutimukherjee2020@gmail.com")
	    	        				.onPage(0)
	    	        				.atPosition(100, 100)
	    	        				.withSize(250, 75)))
	    	        
	    	        
	    	        
	    	        .withSenderInfo(SenderInfoBuilder.newSenderInfo("your_sender_email"))
	    	        .withVisibility(Visibility.ACCOUNT)//only works for templates
	    	        .build();
	    	
	    	 // Create package from template on behalf of another sender
	    	
	        PackageId packageId = eslClient.createPackageOneStep(package1);	//package creation
	        PackageId templateId = eslClient.getTemplateService().createTemplate(package1);	//template creation
	 }

}
