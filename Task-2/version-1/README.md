## Problem Description:
We are looking to create a Java-based API that will use the Google Drive API to preview files.

Initially, this API will take a spreadsheet file, upload it to Google Drive and return a preview URL in the API response.

The objective is to allow users to preview spreadsheets in Google Sheets using a service account, not individual user oauth accounts.

## Changelog:
1. You can now upload any kind of file using this application.
2. You just need to paste the link of the file that you want to upload in google drive from your local computer.

## How to run?
1. On your Maven pom.xml file add the following lines for integrating the dependencies:
```xml
<dependencies>
        <dependency>
            <groupId>com.google.api-client</groupId>
            <artifactId>google-api-client</artifactId>
            <version>2.0.0</version>
        </dependency>
        <dependency>
            <groupId>com.google.oauth-client</groupId>
            <artifactId>google-oauth-client-jetty</artifactId>
            <version>1.34.1</version>
        </dependency>
        <dependency>
            <groupId>com.google.apis</groupId>
            <artifactId>google-api-services-drive</artifactId>
            <version>v3-rev20220815-2.0.0</version>
        </dependency>
    </dependencies>
```
2. Under the same Maven project create a java file named DriveUploader.java.
3. Paste the DriveUploader.java file source code to your newly created DriveUploader.java file.
4. Save the code and hit run to run the program. 

Note: Don't forget to save the credential file under the name "credentials.json" inside the "resources" folder of your maven project.
