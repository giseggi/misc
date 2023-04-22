# misc
```bash
brew services start zookeeper
brew services start kafka
curl -X POST --location "http://localhost:8081/kafka/sendMessage" -d "message=test0416"
brew services stop kafka
brew services stop zookeeper
```
