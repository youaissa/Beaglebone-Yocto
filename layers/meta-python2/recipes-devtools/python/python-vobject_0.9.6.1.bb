SUMMARY = "Python package for parsing and generating vCard and vCalendar files"
HOMEPAGE = "http://vobject.skyhouseconsulting.com/"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE-2.0.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[md5sum] = "06357e96a84d55de2a71b36d39f6853e"
SRC_URI[sha256sum] = "96512aec74b90abb71f6b53898dd7fe47300cc940104c4f79148f0671f790101"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-dateutil \
    ${PYTHON_PN}-numbers \
    "

PNBLACKLIST[python-vobject] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
