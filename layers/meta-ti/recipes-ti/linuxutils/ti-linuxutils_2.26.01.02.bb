require ti-linuxutils.inc

SRC_URI += "file://linuxutils-BKL-fix-2.patch \
			file://linuxutils_2_26-cmemk-fixes.patch \
			file://linuxutils_2_26-sdmak-fixes.patch \
	"

PE = "1"
PV = "2_26_01_02"

SRC_URI[md5sum] = "70b4918bc35c1bcfef34d6ba3fbce0c8"
SRC_URI[sha256sum] = "51266dd928f8d629cd417c869789a6c0d596612120f165619119cbaadfd66ee2"

INSANE_SKIP:${PN} = "installed-vs-shipped"

COMPATIBLE_HOST ?= "null"
COMPATIBLE_HOST:ti-soc = "(.*)"
