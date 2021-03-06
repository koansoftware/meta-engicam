# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017-2018 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel provided and supported by NXP"
DESCRIPTION = "Linux Kernel provided and supported by NXP with focus on \
i.MX Family Reference Boards. It includes support for many IPs such as GPU, VPU and IPU."

require recipes-kernel/linux/linux-imx.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
DEPENDS += "lzop-native bc-native"

SRCBRANCH = "linux-engicam_4.19.35"
LOCALVERSION = "-1.1.0"
KERNEL_SRC ?= "git://github.com/engicam-stable/linux-engicam_4.19.35.git;protocol=https"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH}"
SRCREV = "2c9c573a8580d3b847f964a1b8f1f4c2f0ae185b"

S = "${WORKDIR}/git"

DEFAULT_PREFERENCE = "1"

do_preconfigure_prepend() {
    # meta-freescale/classes/fsl-kernel-localversion.bbclass requires
    # defconfig in ${WORKDIR}
    install -d ${B}
    cp ${S}/arch/${ARCH}/configs/${DEFCONFIG} ${WORKDIR}/defconfig
}

COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"
