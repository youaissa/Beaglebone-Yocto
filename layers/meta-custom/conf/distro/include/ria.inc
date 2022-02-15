DISTRO_VERSION = "3.4"

# These default to 'oecore' and 'nodistro'
SDK_NAME_PREFIX = "${DISTRO}"
SDK_VERSION = "${DISTRO_VERSION}"

TARGET_VENDOR = ""

require conf/distro/include/arm-defaults.inc
require conf/distro/include/egl.inc

# defaultsetup.inc gets includes after ${DISTRO}.conf, so we need to set it here
# to make the python below work. Local, site and auto.conf will override it.
TCMODE ?= "default"

DISTRO_FEATURES:append = " opengl pam systemd ptest vulkan openssh"
DISTRO_FEATURES:remove = "3g sysvinit"
VIRTUAL-RUNTIME_init_manager = "systemd"
PACKAGECONFIG:append:pn-systemd = " resolved networkd"
PACKAGECONFIG:append:pn-qtbase = " gles2 fontconfig examples"
PACKAGECONFIG:remove:pn-gpsd = "qt"
PACKAGECONFIG:append:pn-gstreamer1.0-plugins-bad = " kms"
PACKAGECONFIG:append:pn-ffmpeg = " sdl2"
PACKAGECONFIG:append:pn-igt-gpu-tools = " chamelium"

PREFERRED_PROVIDER_iasl-native = "acpica-native"
PREFERRED_PROVIDER_iasl = "acpica"

LICENSE_FLAGS_WHITELIST += "commercial_gstreamer1.0-libav commercial_ffmpeg commercial_x264 non-commercial"

# Avoid to duplicate the rootfs tarball by generating both tar.gz/tar.xz
IMAGE_FSTYPES:remove = "tar.xz wic.xz"

# By default, meta-ti and TI SDK ship tar.xz rootfs tarball for SD card deployment
# fastboot is preferred for deployment in automation
IMAGE_FSTYPES:append:omap-a15 = " ext4.gz"
IMAGE_FSTYPES:append:beaglebone = " ext4.gz"

INHERIT += "buildhistory"
INHERIT += "image-buildinfo"
BUILDHISTORY_COMMIT = "1"
