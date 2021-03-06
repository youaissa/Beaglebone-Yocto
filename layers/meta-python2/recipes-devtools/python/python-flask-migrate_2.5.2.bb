SUMMARY = "SQLAlchemy database migrations for Flask applications using Alembic"
DESCRIPTION = "Flask-Migrate is an extension that handles SQLAlchemy database \
migrations for Flask applications using Alembic. The database operations are \
provided as command-line arguments under the flask db command."
HOMEPAGE = "https://github.com/miguelgrinberg/flask-migrate/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b69377f79f3f48c661701236d5a6a85"

SRC_URI[md5sum] = "bedeb0366740fda6912fea683be11968"
SRC_URI[sha256sum] = "a96ff1875a49a40bd3e8ac04fce73fdb0870b9211e6168608cbafa4eb839d502"

PYPI_PACKAGE = "Flask-Migrate"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-flask-sqlalchemy \
    ${PYTHON_PN}-alembic \
    ${PYTHON_PN}-flask \
    "

PNBLACKLIST[python-flask-migrate] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
