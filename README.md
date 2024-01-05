KAFKA 1. START ZOOKEEPER 2. START SERVER
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
.\bin\windows\kafka-server-start.bat .\config\server.properties

CREATE TOPIC:
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --create --topic topic_two --partitions 3 --replication-factor 1

LIST OF TOPICS
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list

DESCRIBE A PARTICULAR TOPIC
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --describe --topic topic-name

POST MESSAGES TO A SPESIFIC TOPIC FROM A PRODUCER
.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic topic-ONE
CONSUME MESSAGE FROM A CONSUMER
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic topic-ONE --from-beginning
