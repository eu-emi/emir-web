# EMIR Service Endpoint Browser

A Web front-end to view the service endpoints within EMIR index. The server should be 
installed and running as a main pre-requisite to view the correct entries. The implementation
is mainly based on Vaadin v7 Web framework.

## Build and Run (using Eclipse)

1. Check-out from github into your eclipse workspace

2. Start the MongoDB server on default hostname and port, otherwise change the values in the emir.config configuration file

3. Execute the main JettyServer class from src/test/java/eu/emi/emir/web, this will start
	
	*. EMIR Server
	
	*. Web Server hosting the Web application

4. Open http://localhost:8080 on your browser, type http://localhost:9127 in the address field, then press the button Go.

You are done here!!! 