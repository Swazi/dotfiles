(menu-bar-mode -1)
(tool-bar-mode -1)
(load-theme 'tango-dark t)
(set-default-font "lemon 10")
(set-face-bold-p 'bold nil)

(custom-set-variables
 '(inhibit-startup-screen t))

(setq backup-directory-alist
      `((".*" . ,temporary-file-directory)))
(setq auto-save-file-name-transforms
      `((".*" ,temporary-file-directory t)))

