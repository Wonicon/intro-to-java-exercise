require 'fileutils'

Dir['*.java'].each do |java|
  head = File.readlines(java)[0].split()
  dir = File.join(head[2], head[3])
  dest = File.join(dir, java)

  FileUtils.mkdir_p(dir)
  FileUtils.cp(java, dest)
end
