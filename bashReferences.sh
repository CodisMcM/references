########################################################## Linux Command Line ###################################################################
## Command to check if a folder exists at a location.
## Same thing with a file. Just add the file at the end.
if test -d /file/location/to/test; then echo "exists"; fi

## Command to enter into the file system of a machine running on Android (currently the ADX)

##      1. Navigate to the folder Android/Sdk/platform-tools/
            cd Android/Sdk/platform-tools/
##      2. Enter into the shell inside running device
            ./adb shell
            ## You now have access to the command line inside a device running off your android studio testing platform. 
            
## Changing Directories
cd <Directory Name Here>/<Next Subfolder Here>      ## To jump into a folder
cd ../      ## To jump back a step
cd          ## To jump back to root

ls      # See all files in current directory

## Compiling with g++

g++ -Wall <cpp files> <more cpp files> -o <exe file name>

##  Creating a makefile will help with not having to type in the same file names every time



