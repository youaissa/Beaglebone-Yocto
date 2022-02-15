DESCRIPTION = "TI Inter Process Communication (IPC) Mechanisms (for Uni- and Multi- Processor Configurations)"
HOMEPAGE="http://processors.wiki.ti.com/index.php/Category:IPC"

require ti-ipc.inc
require ti-ipc-common.inc

PR = "${INC_PR}.2"

DEPENDS += "virtual/kernel"

SRC_URI += "file://tiipclad-daemon.sh \
            file://omap_remoteproc.conf \
            file://tiipclad-daemon.service \
            file://0001-Add-kernel-build-dir.patch \
           "

DAEMON = "UNKNOWN"
DAEMON:omap5-evm = "lad_omap54xx_smp"
DAEMON:dra7xx = "lad_dra7xx"
DAEMON:k2hk = "lad_tci6638"
DAEMON:k2l = "lad_tci6630"
DAEMON:k2e = "lad_66ak2e"
DAEMON:k2g = "lad_66ak2g"
DAEMON:omapl138 = "lad_omapl138"

inherit autotools-brokensep pkgconfig update-rc.d systemd

INITSCRIPT_NAME = "tiipclad-daemon.sh"
INITSCRIPT_PARAMS = "defaults 10"

SYSTEMD_SERVICE:${PN} = "tiipclad-daemon.service"

EXTRA_OECONF += "PLATFORM=${PLATFORM} KERNEL_INSTALL_DIR=${STAGING_KERNEL_DIR} KERNEL_BUILD_DIR=${STAGING_KERNEL_BUILDDIR}"

do_compile[depends] += "virtual/kernel:do_shared_workdir"

do_configure() {
    ( cd ${S}; autoreconf -f -i -s )
    oe_runconf
}

do_install:append() {
    install -d ${D}${sysconfdir}/init.d/

    # Modify the startup scripts to point to the right
    # lad daemon executable.
    sed -i -e "s/__LAD_DAEMON__/${DAEMON}/" ${WORKDIR}/tiipclad-daemon.sh
    sed -i -e "s/__LAD_DAEMON__/${DAEMON}/" ${WORKDIR}/tiipclad-daemon.service

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/tiipclad-daemon.service ${D}${systemd_system_unitdir}
    install -d ${D}${sysconfdir}/init.d/
    install -c -m 755 ${WORKDIR}/tiipclad-daemon.sh ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME}
}

do_install:append:dra7xx() {
    install -d ${D}${sysconfdir}/modprobe.d/
    install -c -m 644 ${WORKDIR}/omap_remoteproc.conf ${D}${sysconfdir}/modprobe.d/
}

PACKAGES =+ "${PN}-test"
RDEPENDS:${PN}-test += "${PN}"

FILES:${PN}-test = " \
    ${bindir}/NameServerApp \
    ${bindir}/MessageQApp \
    ${bindir}/MessageQMulti \
    ${bindir}/ping_rpmsg"
