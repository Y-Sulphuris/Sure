cmake_minimum_required(VERSION 3.23)
project(misc)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)
include_directories(src/main/cpp)
include_directories(C:/Users/lidia/.jdks/liberica-1.8.0_345/include)
include_directories(C:/Users/lidia/.jdks/liberica-1.8.0_345/include/win32)
#include_directories(G:/Project/hotspot-87ee5ee27509/hotspot-87ee5ee27509/src/share/vm)

add_executable(misc
        src/main/cpp/misc.cpp)
