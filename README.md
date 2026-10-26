Sample code to try REST and Memory mapped files 


## Running

Each service is started with `server.Server <spring-config.xml>` (configs in `src/main/java/config/`).

- **Facade (`facade.xml`, port 10025)** needs the HMAC secret for client `C1` in the
  `FACADE_HMAC_KEY_C1` environment variable. If it is not set, every request from `C1` is rejected
  with `401`. Every request to `/sample` must carry a valid `envelope.hmac`
  (HMAC-SHA256 of `clientId + requestType`), whatever its request type.
- **`client.ClientTester`** reads the same `FACADE_HMAC_KEY_C1` variable to sign its requests.
- **App1 / App2 backends (ports 11025 / 12025)** and all admin ports (10091 / 11091 / 12091) listen on
  `127.0.0.1` only. The backends have no authentication and are meant to be reached only through the
  facade. To run them on another host, change `bindHost` in the yml files and put
  network controls in front of them.
