ARMFILESPATHS := "${THISDIR}/${PN}:"

COMPATIBLE_MACHINE:generic-arm64 = "generic-arm64"
FILESEXTRAPATHS:prepend:generic-arm64 = "${ARMFILESPATHS}"
SRC_URI:append:generic-arm64 = " \
    file://defconfig.patch \
    file://tcpci.cfg \
    "

FILESEXTRAPATHS:prepend:qemuarm64-secureboot = "${ARMFILESPATHS}"
SRC_URI:append:qemuarm64-secureboot = " \
    file://zone_dma_revert.patch \
    file://tee.cfg \
    "
