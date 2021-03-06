SUMMARY = "Library for developers to extract data from Microsoft Excel (tm) spreadsheet files"
DESCRIPTION = "Extract data from Excel spreadsheets (.xls and .xlsx,\
 versions 2.0 onwards) on any platform. Pure Python (2.6, 2.7, 3.2+). \
Strong support for Excel dates. Unicode-aware."
HOMEPAGE = "http://www.python-excel.org/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=5f4244d51fcc1e7cc2d43e96891b2f80"

SRC_URI[md5sum] = "e5d5b96924d791b22898b622eb3e918e"
SRC_URI[sha256sum] = "546eb36cee8db40c3eaa46c351e67ffee6eeb5fa2650b71bc4c758a29a1b29b2"

inherit pypi setuptools

RDEPENDS:${PN} += "${PYTHON_PN}-compression ${PYTHON_PN}-io ${PYTHON_PN}-pprint ${PYTHON_PN}-shell"

BBCLASSEXTEND = "native nativesdk"

PNBLACKLIST[python-xlrd] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
