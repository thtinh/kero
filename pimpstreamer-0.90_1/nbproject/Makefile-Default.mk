#
# Gererated Makefile - do not edit!
#
# Edit the Makefile in the project folder instead (../Makefile). Each target
# has a -pre and a -post target defined where you can add customized code.
#
# This makefile implements configuration specific macros and targets.


# Environment
MKDIR=mkdir
CP=cp
CCADMIN=CCadmin
RANLIB=ranlib
CC=
CCC=
CXX=
FC=

# Include project Makefile
include pimpstreamer-0.90_1-Makefile.mk

# Object Directory
OBJECTDIR=build/Default/None-Windows

# Object Files
OBJECTFILES=

# C Compiler Flags
CFLAGS=

# CC Compiler Flags
CCFLAGS=
CXXFLAGS=

# Fortran Compiler Flags
FFLAGS=

# Link Libraries and Options
LDLIBSOPTIONS=

# Build Targets
.build-conf: ${BUILD_SUBPROJECTS} 
	cd ../../pimpstreamer-0.90 && make -f Makefile

# Subprojects
.build-subprojects:

# Clean Targets
.clean-conf:
	cd ../../pimpstreamer-0.90 && make -f Makefile clean

# Subprojects
.clean-subprojects: