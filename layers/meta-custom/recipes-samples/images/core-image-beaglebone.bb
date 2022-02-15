require recipes-core/images/core-image-base.bb 

IMAGE_FEATURES += "\
        package-management \
        ssh-server-openssh \
        hwcodecs \   
    "

CORE_IMAGE_BASE_INSTALL +="\
    packagegroup-bbb \
    "
inherit extrausers

ROOT_PASSWORD="root"
USER_PASSWORD="user"

EXTRA_USERS_PARAMS = "\
		    useradd -p '$(openssl passwd ${USER_PASSWORD})' user; \
		    usermod -p '$(openssl passwd ${ROOT_PASSWORD})' root; \
		    "
