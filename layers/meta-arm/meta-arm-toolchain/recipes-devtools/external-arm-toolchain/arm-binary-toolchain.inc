INHIBIT_DEFAULT_DEPS = "1"

FILES:${PN} = "${datadir} ${bindir}"

BINNAME = "${@d.getVar("BPN").strip("gcc-")}"

do_install() {
    install -d ${D}${datadir}/${BINNAME}/
    cp -r ${S}/. ${D}${datadir}/

    install -d ${D}${bindir}
    # Symlink all executables into bindir
    for f in ${D}${datadir}/bin/${BINNAME}-*; do
        ln -rs $f ${D}${bindir}/$(basename $f)
    done
}

INSANE_SKIP:${PN} = "already-stripped libdir staticdev file-rdeps arch dev-so"

INHIBIT_SYSROOT_STRIP = "1"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

BBCLASSEXTEND = "native nativesdk"
