require x-load.inc

#FILESPATHPKG_prepend = "x-load-git:x-load-git/${MACHINE}"

PV = "1.5.1"
PR ="r3"
PE = "1"

SRCREV:pn-${PN} = "c4289f1bee035dea41536c5ba5e1bc36c7d493c4"
SRC_URI = "git://gitorious.org/x-loader/x-loader.git;branch=master;protocol=git \
"

S = "${WORKDIR}/git"

XLOAD_MACHINE:beagleboard = "omap3530beagle_config"
CONFIG_HEADER:beagleboard = "1"
XLOAD_MACHINE:omap3-touchbook = "omap3530beagle_config"

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_HOST ?= "null"
COMPATIBLE_HOST:ti-soc = "(.*)"
