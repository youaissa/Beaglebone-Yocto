SUMMARY = "Test applications for TI DEC (v4l2 decoder for IMG D5520)"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://main.c;beginline=1;endline=14;md5=f17e17d664f72942124e4fcf06c178ee"

DEPENDS = "libdrm ffmpeg"

inherit autotools pkgconfig

COMPATIBLE_MACHINE = "j7"

PR = "r1"
SRCREV = "94a80c8c090dbfdc7fafd4e5bb78c2091e715af2"

EXTRA_OEMAKE = "CC="${CC}""
TARGET_CC_ARCH += "${LDFLAGS}"

BRANCH = "master"
SRC_URI = "git://git.ti.com/jacinto7_multimedia/viddec-test-app.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"
