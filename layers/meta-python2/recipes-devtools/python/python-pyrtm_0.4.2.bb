SUMMARY = "Python interface for Remember The Milk API"
AUTHOR = "Sridhar Ratnakumar / srid"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=a53cbc7cb75660694e138ba973c148df"

PYPI_PACKAGE_EXT = "tar.bz2"

SRC_URI[md5sum] = "7c87da94656b620dfe532ca63d642eb8"
SRC_URI[sha256sum] = "b2d701b25ad3f9a1542057f3eb492c5c1d7dbe2b8d1e8f763043dcc14ee1d933"

inherit pypi setuptools

PACKAGES =+ "${PN}-tests ${PN}-samples"

FILES:${PN}-samples += " \
    ${PYTHON_SITEPACKAGES_DIR}/rtm/samples \
"

FILES:${PN}-tests += " \
    ${PYTHON_SITEPACKAGES_DIR}/rtm/tests \
"

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-netclient \
"

RDEPENDS:${PN}-samples += " \
    ${PN} \
"

RDEPENDS:${PN}-tests += " \
    ${PN} \
    ${PYTHON_PN}-unittest \
"

# meta-python recipe did not follow Debian naming
PROVIDES += "pyrtm"

PNBLACKLIST[python-pyrtm] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
