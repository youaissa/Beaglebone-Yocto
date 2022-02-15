# Copyright (C) 2022 Yassine OUAISSA <ouaissa24@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Add Custom packages"
LICENSE = "CLOSED"
DEPENDS = ""

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS:packagegroup-bbb = " \
    e2fsprogs \
    e2fsprogs-e2fsck \
    e2fsprogs-mke2fs \
    gptfdisk \
    parted \
    util-linux \
    udev \
    coreutils \
    cpufrequtils \
    file \
    nmap \
    gptfdisk \
    hostapd \
    ldd \
    lsof \
    tcpdump \
    iptables \
    libgpiod \
    libgpiod-tools \
    kernel-modules \
    openssh-sftp-server \
    python3-misc \
    python3-modules \
    rsync \
    strace \
    ltrace \
    v4l-utils \
    grep \
    htop \
    i2c-tools \
    canutils \
    libsocketcan \
    dbus \
    qtbase-plugins \
    qtbase-tools \
    qtdeclarative \
    qtdeclarative-plugins \
    qtdeclarative-tools \
    qtdeclarative-qmlplugins \
    qtmultimedia \
    qtmultimedia-plugins \
    qtmultimedia-qmlplugins \
    qtsvg \
    qtsvg-plugins \
    qtsensors \
    qtimageformats-plugins \
    qtsystems \
    qtsystems-tools \
    qtsystems-qmlplugins \
    qtscript \
    qt3d \
    qt3d-qmlplugins \
    qt3d-tools \
    qtwebkit \
    qtwebkit-qmlplugins \
    qtconnectivity-qmlplugins \
    qtbase\
    qtbase-plugins \
    qtbase-tools \
    qtdeclarative \
    qtsensors \
    qt3d \
    qtsystems \
    qtsystems-tools \
    alsa-lib \
    alsa-utils \
    cups \
    memtester \
    mtd-utils \
    ethtool \
    devmem2 \
    acpid \
    procps \
    zlib \
    iproute2 \
    boost \
    openssh \
"
