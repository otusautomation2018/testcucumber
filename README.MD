### README

##### Create Grid

Create hub with parameters:
-port `20000`
```bash
java -jar selenium-server-standalone-3.12.0.jar -role hub -port 20000
```

Create node with parameters:

-port `20001`

-browser `browserName=chrome` `maxInstances=3`

-timeout `50` 

-maxSession `3`

`http://xxx.xxx.x.xx` - replace on your hub
```bash
java -jar selenium-server-standalone-3.12.0.jar -role node -hub http://xxx.xxx.x.xx:20000/grid/register/ -port 20001 -browser browserName=chrome,maxInstances=3 -timeout 50 -maxSession 3
```

##### Run tests
```bash
mvn test -Dbrowser=chrome-remote
```