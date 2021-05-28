# Contact-Management
Contact Management

Project structure
ContactMgtWeb -module
              src/main/java/
                           com.interview.contactmgt.rest - contains rest contoller which serve rest layer requests
                           com.interview.contactmgt.web - contains web controller which serve frontend or UI requests
               
             ContactMgtWeb/src/main/resources/    -contains log4j configuration  property files
             ContactMgtWeb/src/main/webapp/       -contans index.jsp file as well as WEB-INF folder which contains
                                                   deployement descriptor web.xml and other configuration file which
                                                   we use for spring configuration and jsp folder also which contains
                                                   all jsp pages
                                                   
                                                   
 ContactMgtService  -module                                                  
                      src/main/java/
                                   Com.Interview.contactmgt.service-  contains have all services interfaces
                                   com.interview.contactmgt.service.impl- contains have all service implemented classes
                                   com.interview.contactmgt.util- contains all utility classes which required
                   
                   ContactMgtService/src/main/resources/ - contains configuration file which config service layer
                   
                   ContactMgtService/src/test/java/  
                                    com.interview.contactmgt.test -contains all service layer unit testing classes
                                    
 ContactMgtDao  -module
                  src/main/java/  
                              com.interview.contactmgt.dao  -contains all dao layer interfaces
                              com.interview.contactmgt.dao.impl  -contains all dao implemented classes
                              com.interview.contactmgt.dto  - contains all dto classes
                              com.interview.contactmgt.exception -contains all exception layer classes
                              com.interview.contactmgt.model  -contains all database model classes
                              com.interview.contactmgt.util  -contains all utility classes which required
                              
                  /ContactMgtDao/src/main/resources/  -contains all hibernate configuration and db configuration
                 
                 /ContactMgtDao/src/test/java/
                                  com.interview.contactmgt.test  -contains all dao layer unit testing classes
             
             
 I have create basically 2 layers rest as well web so web serve all request which comes from ui and rest you can test via postaman and restclient so application 
 support for both stuff,if you want to test rest layer i have create api specification for that too i have share same in mail as well i have create one     deployement document too which provide more details all document provide using some standard documents
 i have create 2 documents one for rest api specification for rest layer testing and one for deployement i have attach both in have with db script.
 
 
 Short guide for project deployement
 1.take pull for code on repo
 2.create db using script which i have share in mail
 3.create war for project using eclipse or commond line
 4.then you can depolye on server where you want

Note-1.configuration you can change as required like db name username password etc for db related and as well change log4j path change as you want
     2.for now i have put igonre for junit testing methods because dont want build issue on another system once you create db you can remove igonre and test the test cases using those method
 

             
                          
