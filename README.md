This repo illustrates what seems to be a bug in the SSL connection mechanism of Android platform. The bug can be stated as:

**During SSL handshake, as part of the `Client Hello` packet, the Android client sends a random timestamp in the `gmt_unix_time` field**.

The issue is seen only in **Lollipop and above, i.e., API level 21 and above**. The problem is seen both with the (now-deprecated) Apache HTTP client and the `HttpUrlConnection`.

The issue has been reproduced on emulators as well as real devices running Android 5.0.2 and 5.1.

###App explanation

This app simply does HTTP GETs on two github API URLs. Both the URLs use `https://` scheme. The firsl GET is done using Apache http client and the second using HttpUrlConnection.


###Steps to reproduce

  1. If you are using a real device, make sure you have a sniffer running to capture packets from your device. If you are using an emulator, start it using `./emulator -tcpdump tlsbugcapture.pcap your_avd_name`
  2. Run the app
  3. After it prints responses from both URLs in the log, open the sniffer capture in Wireshark
  4. Search for the `Client Hello` packets in the sniffer capture (under **Protocol** column, look for **TLSv1.2**)
  5. Expand the tree as follows: `Secure Sockets Layer` -> `TLSv1.2 Record Layer` -> `Handshake Protocol` -> `Random`
  6. Here, you see a `gmt_unix_time:` field. The value for this field should be the current time. However, in Lollipop and above it displays a random time.


###Disclaimer

This repo is meant to provide the bare minimum code to reproduce the issue. As such, several shortucts might have been taken. Best practices might have been flouted. It is not advised to reuse any of this code or treat it as a sample for how to make HTTPS requests etc.