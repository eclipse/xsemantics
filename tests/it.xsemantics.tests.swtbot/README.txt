In Linux you can run UI tests in a different display
(so that you can continue working without UI tests getting in your way)

sudo apt-get install metacity xserver-xephyr

export MAVEN_OPTS="-Xmx512m -XX:MaxPermSize=256m"
Xephyr -screen 1024x768 :50 &
sleep 5
export DISPLAY=:50
metacity --sm-disable --replace 2> ~/tmp/metacity.err &


You can then run mvn from that terminal, or use an Eclipse
launch configuration where the environment variable DISPLAY is set
to the value :50