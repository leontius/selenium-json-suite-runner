java -Dselenium.LOGGER=./logs/node-server.log \
	-Dselenium.LOGGER.level=ALL \
	-jar ~/bin/selenium-server-standalone-3.6.0.jar \
	-role node \
	-nodeConfig	./node.json \
	
